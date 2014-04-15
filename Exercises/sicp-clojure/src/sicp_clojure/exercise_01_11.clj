(ns sicp-clojure.exercise_01_11
  (:gen-class))

(defn f [n]
  (if (< n 3)
  	  n
      (+ (f (- n 1)) (* 2 (f (- n 2))) (* 3 (f (- n 3))))))

(defn f2 [n]
  (defn iter [a b c n]
  	(if (= n 0)
  		c
  		(iter b c (+ (* 3 a) (* 2 b) c) (- n 1))))
  (if (< n 3)
  	n
  	(iter 0 1 2 (- n 2))))