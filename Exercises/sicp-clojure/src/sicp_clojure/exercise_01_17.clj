(ns sicp-clojure.exercise_01_17
  (:gen-class))

(defn m1 [a b]
  (if (= b 0)
      0
      (+ a (m1 a (- b 1)))))

; exerise 1.17
(defn duble [a] (* a 2))
(defn halve [a] (/ a 2))

(defn m2 [a b]
  (cond (= b 0) 0
  	    (= b 1) a
  	    (even? b) (m2 (duble a) (halve b))
  	    :else (+ a (m2 a (- b 1)))))

; exercise 1.18
(defn m3 [a b]
  (defn iter [a b acc]
    (cond (= b 0) acc
          (even? b) (iter (duble a) (halve b) acc)
          :else      (iter a (- b 1) (+ acc a))))
  (iter a b 0))