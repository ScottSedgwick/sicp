(ns sicp-clojure.exercise_01_24
  (:gen-class))

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

(defn prime? [n] (fast-prime? n 10))

(defn report-prime [n elapsed-time]
  (println)
  (print n)
  (print " *** ")
  (print elapsed-time))

(defn start-prime-test [n start-time]
  (if (prime? n) (report-prime n (- (System/currentTimeMillis) start-time))))

(defn timed-prime-test [n]
  (start-prime-test n (System/currentTimeMillis)))

(defn search-for-primes [minn maxn]
  (declare iter)
  (defn test-and-proceed [n]
  	(timed-prime-test n)
  	(iter (+ n 1)))
  (defn iter [n]
  	(cond (even? n) (iter (+ n 1))
  		    (not (> n maxn)) (test-and-proceed n)))
  (iter minn))

; 1 ]=> (search-for-primes 1000000 1000038)

; 1000003 *** 1.
; 1000033 *** 1.
; 1000037 *** 0.
