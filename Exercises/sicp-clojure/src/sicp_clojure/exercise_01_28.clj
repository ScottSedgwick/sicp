(ns sicp-clojure.exercise_01_28
  (:gen-class))

; Miller-Rabin test: if n is a prime number, and a is any positive integer less than n,
; then a^(n-1) is congruent to 1 modulo n.

; m = a^(n-1)
; Check that m is not a "non-trivial square root of 1 modulo n", that is, a number not
; equal to 1 or n whose square is equal to 1 mod n.

(defn square [n] (int (Math/pow n 2)))

(defn expmod [base exp m]
  (cond (= exp 0)   1
        (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
        :else       (rem (* base (expmod base (- exp 1) m)) m)))

(defn fermat-test [n]
  (defn try-it [a] (= (expmod a n n) a))
  (try-it (+ 1 (rand-int (- n 1)))))

(defn prime? [n f times]
  (cond (= times 0) true
        (f n)       (prime? n f (- times 1))
        :else       false))

(defn fermat-prime? [n] (prime? n fermat-test 10))

; Miller-Rabin test:
; to test primality of N:
; 1) randomly select a < n
; 2) raise a to (n-1) using expmod
; 3) when squaring in expmod, check to see if we have discovered a "nontrivial square root of
;    1 mod n" that is, a number not equal to 1 or n-1, whose square is equal to 1 mod n.

(defn square-check [x m]
  (if (and (not (or (= x 1) (= x (- m 1))))
           (= (rem (square x) m) 1))
      0
      (rem (square x) m)))

(defn expmod [base exp m]
  (cond (= exp 0)   1
        (even? exp) (square-check (expmod base (/ exp 2) m)  m)
        :else       (rem (* base (expmod base (- exp 1) m)) m)))

(defn miller-rabin-test [n]
  (defn try-it [a]
     (= (expmod a (- n 1) n) 1))
  (try-it (+ 2 (rand-int (- n 2)))))

(defn mr-prime? [n] (prime? n miller-rabin-test 10))