(ns sicp-clojure.exercise_01_04-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_04 :refer :all]))

(deftest ex_01_04-test
  (testing "+ABS #1" (is (= (a-plus-abs-b 3 4) 7)))
  (testing "+ABS #1" (is (= (a-plus-abs-b 3 (- 4)) 7)))
  (testing "+ABS #1" (is (= (a-plus-abs-b (- 3) 4) 1)))
  (testing "+ABS #1" (is (= (a-plus-abs-b (- 3) (- 4)) 1)))
)

