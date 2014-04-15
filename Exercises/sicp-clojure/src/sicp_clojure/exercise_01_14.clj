(ns sicp-clojure.exercise_01_14
  (:gen-class))

(defn first-denomination [kinds-of-coins]
  (cond (= kinds-of-coins 1) 1
        (= kinds-of-coins 2) 5
        (= kinds-of-coins 3) 10
        (= kinds-of-coins 4) 25
        (= kinds-of-coins 5) 50))

(defn cc [amount kinds-of-coins]
  (cond (= amount 0) 1
        (or (< amount 0) (= kinds-of-coins 0)) 0
        :else (+ (cc amount
                     (- kinds-of-coins 1))
                 (cc (- amount
                        (first-denomination kinds-of-coins))
                     kinds-of-coins))))

(defn count-change [amount]
  (cc amount 5))


; To calculate (count-change 11):
;  (cc 11 5) => (+ (cc 11 4)
;                  (cc -39 5))
;  (cc -39 5) => 0
;  (cc 11 4) => (+ (cc 11 3)
;                  (cc -14 4))
;  (cc -14 4) => 0
;  (cc 11 3) => (+ (cc 11 2)
;                  (cc 1 3))

; To hell with it, I'm guessing.  I suspect the order of growth is O(n^(x - 1)),
; where x is the number of coins.