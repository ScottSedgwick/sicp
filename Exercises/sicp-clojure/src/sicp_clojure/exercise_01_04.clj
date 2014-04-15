(ns sicp-clojure.exercise_01_04
  (:gen-class))

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))