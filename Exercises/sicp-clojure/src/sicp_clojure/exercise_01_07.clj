(ns sicp-clojure.exercise_01_07
  (:gen-class))

;; Original code from book
(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn square [x] (Math/pow x 2))

(defn good-enough? [guess x]
  (< (Math/abs (- (square guess) x)) 0.001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
      guess
      (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

;; In terms of accuracy, if the number is small, and 0.001 is an
;; appreciable fraction of the square roots value, then using 0.0001
;; as an acceptable error range is patently unacceptable.
;; For very large numbers (in some systems, depending on the internal
;; represenation of integers) the average function could overflow on
;; addition, which would result in a large negative number. Though,
;; to do that, the initial value would also have to exceed the
;; number size...

(defn sqrt2 [x]
  (defn good-enough? [g1 g2]
  	(< (/ (Math/abs (- g1 g2)) x) 0.0000001))
  (defn sqrt-iter [g1 g2]
  	(if (good-enough? g1 g2)
  		g2
  		(sqrt-iter g2 (improve g2 x))))
  (sqrt-iter 10000000 1.0))
