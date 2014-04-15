(ns sicp-clojure.exercise_01_02-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_02 :refer :all]))

(deftest ex_01_02-test
  (testing "Expression value" (is (= expression (- (/ 74 300))))))