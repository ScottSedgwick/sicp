(ns sicp-clojure.exercise_01_23
  (:gen-class))

(defn nextn [n]
  (if (= n 2)
      3
      (+ n 2)))

(defn divides? [a b] (= (rem b a) 0))

(defn square [n] (Math/pow n 2))

(defn find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) n
        (divides? test-divisor n) test-divisor
        :else (find-divisor n (nextn test-divisor))))

(defn smallest-divisor [n] (find-divisor n 2))

(defn prime? [n] (= n (smallest-divisor n)))

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
; 1000033 *** 0.
; 1000037 *** 1.

; Given that the slowest test is now down to 1 ms, I'm not going to bother to test the rest.