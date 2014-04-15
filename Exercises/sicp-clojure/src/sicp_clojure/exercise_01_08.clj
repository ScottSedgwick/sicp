(ns sicp-clojure.exercise_01_08
  (:gen-class))

(defn newton-approx [improve x]
  (defn good-enough? [g1 g2]
  	(< (/ (Math/abs (- g1 g2)) x) 0.0000001))
  (defn iter [g1 g2]
  	(if (good-enough? g1 g2)
  		g2
  		(iter g2 (improve g2 x))))
  (iter 10000000 1.0))

(defn sqrt-improve [guess x]
  (/ (+ (/ x guess) guess) 2))

(defn square [x] (Math/pow x 2))

(defn cbrt-improve [guess x]
  (/ (+ (/ x (square guess)) (* 2 guess)) 3))

(defn sqrt [x] (newton-approx sqrt-improve x))

(defn cbrt [x] (newton-approx cbrt-improve x))