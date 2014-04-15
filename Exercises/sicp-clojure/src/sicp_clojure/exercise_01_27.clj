(ns sicp-clojure.exercise_01_27
  (:gen-class))

; Exercise 1.27: Demonstrate that the Carmichael numbers listed in Footnote 1.47
; (Carmichael numbers: 561, 1105, 1729, 2465, 2821, 6601)
; really do fool the Fermat test. That is, write a procedure that takes an
; integer n and tests whether an is congruent to a modulo n for every a < n, and
; try your procedure on the given Carmichael numbers.

; Fermat’s Little Theorem: If n is a prime number and a is any positive integer
; less than n, then a raised to the nth power is congruent to a modulo n.
; That is, a^n mod n == a

(defn square [n] (int (Math/pow n 2)))

(defn expmod [base exp m]
  (cond (= exp 0)   1
        (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
        :else       (rem (* base (expmod base (- exp 1) m)) m)))

(defn congruent [a n]
  (= (expmod a n n) a))

(defn nums [n] (range (- n 1) 0 (- 1)))

(defn congruent-test [n]
  (every? (fn [a] (congruent a n)) (nums n)))

