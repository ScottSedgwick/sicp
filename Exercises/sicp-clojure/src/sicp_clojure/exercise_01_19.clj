(ns sicp-clojure.exercise_01_19
  (:gen-class))

(defn p1 [p q] (+ (Math/pow p 2) (Math/pow q 2)))

(defn q1 [p q] (+ (Math/pow q 2) (* 2 p q)))

(defn fib-iter [a b p q count]
  (cond
    (= count 0) b
    (even? count)
      (fib-iter a b (p1 p q) (q1 p q) (/ count 2))
    :else
      (fib-iter (+ (* b q) (* a q) (* a p))
                (+ (* b p) (* a q))
                p q (- count 1))))

(defn fib [n]
  (fib-iter 1 0 0 1 n))