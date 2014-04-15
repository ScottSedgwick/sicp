(ns sicp-clojure.exercise_01_21
  (:gen-class))

(defn divides? [a b] (= (rem b a) 0))

(defn find-divisor [n test-divisor]
  (cond (> (Math/pow test-divisor 2) n) n
        (divides? test-divisor n) test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n] (find-divisor n 2))

(defn prime? [n] (= n (smallest-divisor n)))


(defn expmod [base exp m]
  (cond (= exp 0) 1
        (even? exp) (int (rem (Math/pow (expmod base (/ exp 2) m) 2) m))
        :else       (int (rem (* base (expmod base (- exp 1) m)) m))))

(defn fermat-test [n]
  (defn try-it [a] (= (expmod a n n) a))
  (try-it (+ 1 (rand-int (- n 1)))))

(defn fast-prime? [n times]
  (cond (= times 0) true
        (fermat-test n) (fast-prime? n (- times 1))
        :else false))
