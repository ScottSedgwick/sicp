(ns sicp-clojure.exercise_01_03-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_03 :refer :all]))

(deftest ex_01_03-test
  (testing "Square" (is (= (square 2) 4.0)))
  (testing "Map"    (is (= (map square '(1 2 3)) '(1.0 4.0 9.0))))
  (testing "Take"   (is (= (take 2 '(1 2 3 4)) '(1 2))))
  (testing "tsort"  (is (= (largest-n 2 1 2 3) '(3 2))))
  (testing "L2S #1" (is (= (largest-2-squared 1 2 3) 13.0)))
  (testing "L2S #2" (is (= (largest-2-squared 5 4 3) 41.0)))
  (testing "L2S #3" (is (= (largest-2-squared 4 6 2) 52.0)))
)