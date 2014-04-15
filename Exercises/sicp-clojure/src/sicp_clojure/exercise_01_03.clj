(ns sicp-clojure.exercise_01_03
  (:gen-class))

(defn square [x] (Math/pow x 2))

(defn sum-squares [lst]
  (reduce + 0 (map square lst)))

(defn largest-n [n & values]
  (take n (reverse (sort values))))

(defn largest-2-squared [a b c]
  (sum-squares (largest-n 2 a b c)))
