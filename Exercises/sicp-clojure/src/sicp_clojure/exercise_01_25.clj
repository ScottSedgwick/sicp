(ns sicp-clojure.exercise_01_25
  (:gen-class))

(defn square [n] (Math/pow n 2))

; Original expmod:
(defn expmod [base exp m]
  (cond (= exp 0)   1
        (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
        :else       (rem (* base (expmod base (- exp 1) m)) m)))

; fast-expt:
(defn fast-expt [b n]
   (cond (= n 0)   1
         (even? n) (square (fast-expt b (/ n 2)))
         :else     (* b (fast-expt b (- n 1)))))

; Alyssa P. Hacker's expmod:
(defn expmod [base exp m]
   (rem (fast-expt base exp) m))

; The original expmod uses squaring and halving the exponent, which makes
; it's order of growth O(log n).

; Alyssa's version allows its results to grow unchecked, whereas expmods
; intermediate results are always modulo m. For this reason it can suffer
; from buffer overflow issues when dealing with large numbers.