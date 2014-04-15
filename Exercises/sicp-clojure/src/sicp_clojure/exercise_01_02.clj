(ns sicp-clojure.exercise_01_02
  (:gen-class))

(def expression (/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
                   (* 3 (- 6 2) (- 2 7))))
