(ns sicp-clojure.exercise_01_17-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_17 :refer :all]))

(deftest ex_01_17-test
  (testing "m1 2 3" (is (= (m1 2 3) 6)))
  (testing "m2 2 3" (is (= (m2 2 3) 6)))
  (testing "m3 2 3" (is (= (m3 2 3) 6)))
)