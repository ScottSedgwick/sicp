(ns sicp-clojure.exercise_01_16
  (:gen-class))

; Naive recursive expotentiation
(defn expt1 [b n]
  (if (= n 0)
      1
      (* b (expt1 b (- n 1)))))

; Naive iterative expotentiation
(defn expt-iter [b counter product]
  (if (= counter 0)
      product
      (expt-iter b
        (- counter 1)
        (* b product))))

(defn expt2 [b n]
   (expt-iter b n 1))

; Fast recursive expotentiation
(defn square [x] (Math/pow x 2))

(defn fast-expt1 [b n]
   (cond (= n 0) 1
         (even? n) (square (fast-expt1 b (/ n 2)))
         :else (* b (fast-expt1 b (- n 1)))))

; Write a fast iterative expotentiation function
(defn fast-expt-iter [b n acc]
  (cond (= n 0) acc
        (even? n) (fast-expt-iter (square b) (/ n 2) acc)
        :else (fast-expt-iter b (- n 1) (* acc b))))

(defn fast-expt2 [b n]
  (fast-expt-iter b n 1))
