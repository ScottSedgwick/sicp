(ns sicp-clojure.exercise_01_10
  (:gen-class)
  (:require [sicp-clojure.exercise_01_08 :refer :all]))

(defn A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (- x 1) (A x (- y 1)))))

(defn f [n] (A 0 n))
(defn g [n] (A 1 n))
(defn h [n] (A 2 n))
(defn k [n] (* 5 n n))

(defn f2 [n] (* 2 n))

(defn g2 [n]
  (if (= n 0) 0 (Math/pow 2 n)))

(defn rp [p n]
  (cond (= n 1) p
        :else (Math/pow p (rp p (- n 1)))))

(defn h2 [n]
  (cond (= n 0) 0
        (= n 1) 2
        :else (rp 2 n)))

(defn k2 [n] (* 5 (square n)))
