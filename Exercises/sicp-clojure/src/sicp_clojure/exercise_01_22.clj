(ns sicp-clojure.exercise_01_22
  (:gen-class)
  (:require [sicp-clojure.exercise_01_21 :refer :all]))

(defn report-prime [n elapsed-time]
  (println)
  (print n)
  (print " *** ")
  (print elapsed-time))

(defn now [] (System/currentTimeMillis))

(defn start-prime-test [n start-time]
  (if (prime? n) (report-prime n (- (now) start-time))))

(defn timed-prime-test [n]
  (start-prime-test n (now)))

(defn search-for-primes [min max]
  (declare iter)
  (defn test-and-proceed [n]
  	(timed-prime-test n)
  	(iter (+ n 1)))
  (defn iter [n]
  	(cond (even? n) (iter (+ n 1))
  		    (not (> n max)) (test-and-proceed n)))
  (iter min))


; 1 ]=> (search-for-primes 1000 1020)

; 1009 *** 0.
; 1013 *** 0.
; 1019 *** 0.


; 1 ]=> (search-for-primes 10000 10038)

; 10007 *** 0.
; 10009 *** 0.
; 10037 *** 0.


; 1 ]=> (search-for-primes 100000 100045)

; 100003 *** 0.
; 100019 *** 0.
; 100043 *** 0.


; 1 ]=> (search-for-primes 1000000 1000038)

; 1000003 *** 1.
; 1000033 *** 0.
; 1000037 *** 1.


; As for an increase in calculation time, well, maybe?  Apparently lisp interpreters used
; to be slower.  I can barely measure the time taken for the largest of these tests.
