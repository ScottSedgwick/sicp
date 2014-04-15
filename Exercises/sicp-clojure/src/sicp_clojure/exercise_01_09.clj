(defn +1 [a b]
  (if (= a 0) b (inc (+1 (dec a) b))))

;; (+1 4 5)
;;   (inc (+1 3 5))
;;     (inc (inc (+1 2 5)))
;;       (inc (inc (inc (+1 1 5))))
;;         (inc (inc (inc (inc (+1 0 5)))))
;;         (inc (inc (inc (inc 5))))
;;       (inc (inc (inc 6)))
;;     (inc (inc 7))
;;   (inc 8)
;; 9

;; +1 is not tail-recursive, because the processor still needs to execute
;; operations as it exits the stack.


(defn +2 [a b]
  (if (= a 0) b (+2 (dec a) (inc b))))

;; (+2 4 5)
;;   (+2 3 6)
;;     (+2 2 7)
;;       (+2 1 8)
;;         (+2 0 9)
;;         9
;;       9
;;     9
;;   9
;; 9

;; +2 is tail recursive, because once the maximum depth of recursion is
;; reached, the answer is finished and just needs to be passed out. It is
;; therefore easy for the compiler to refactor this into a loop.