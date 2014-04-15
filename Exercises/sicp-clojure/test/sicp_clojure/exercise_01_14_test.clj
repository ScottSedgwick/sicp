(ns sicp-clojure.exercise_01_14-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_14 :refer :all]))

(deftest cc-test
  (testing "count-change 11" (is (= (count-change 11) 4))))