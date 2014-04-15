(ns sicp-clojure.exercise_01_11-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_11 :refer :all]))

(deftest f-test
  (testing "f 1" (is (= (f 1) 1)))
  (testing "f 2" (is (= (f 2) 2)))
  (testing "f 3" (is (= (f 3) 4)))
  (testing "f 4" (is (= (f 4) 11)))
  (testing "f 5" (is (= (f 5) 25)))
  (testing "f 6" (is (= (f 6) 59)))
)

(deftest f2-test
  (testing "f2 1" (is (= (f2 1) 1)))
  (testing "f2 2" (is (= (f2 2) 2)))
  (testing "f2 3" (is (= (f2 3) 4)))
  (testing "f2 4" (is (= (f2 4) 11)))
  (testing "f2 5" (is (= (f2 5) 25)))
  (testing "f2 6" (is (= (f2 6) 59)))
)