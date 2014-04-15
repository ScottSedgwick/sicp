(ns sicp-clojure.exercise_01_12
  (:gen-class))

(defn zip [l1 l2]
  (map vector l1 l2))

(defn sum-vector [v]
  (+ (peek (pop v)) (peek v)))

(defn sum-offset [lst]
  (map sum-vector (zip lst (rest lst))))

(defn append [lst e]
  (reverse (cons e (reverse lst))))

(defn pascal [n]
  (if (= n 0)
      '(1)
      (append (cons 1 (sum-offset (pascal (- n 1)))) 1)))

; This is a far more efficient iterative algorithm for Pascal's triangle.
(defn pascal2 [n]
  (defn ptvalue [k prev]
  	(/ (* prev (- n k)) (+ k 1)))
  (defn iter [k prev]
  	(if (= k n)
  		'()
  		(cons (ptvalue k prev) (iter (+ k 1) (ptvalue k prev)))))
  (cons 1 (iter 0 1)))
