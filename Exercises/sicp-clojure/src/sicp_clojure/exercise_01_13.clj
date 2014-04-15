(ns sicp-clojure.exercise_01_13
  (:gen-class)
  (:require [clojure.math.numeric-tower :refer :all]))


(defn fib1 [n]
  (cond (< n 2) n
        :else (+ (fib1 (- n 1)) (fib1 (- n 2)))))

(defn fib2 [n]
  (def phi (/ (+ 1 (sqrt 5)) 2))
  (round (/ (Math/pow phi n) (sqrt 5))))