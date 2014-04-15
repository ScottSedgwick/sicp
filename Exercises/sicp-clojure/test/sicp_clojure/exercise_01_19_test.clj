(ns sicp-clojure.exercise_01_19-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_19 :refer :all]))

(deftest ex_01_19-test
  (testing "fib 0" (is (= (fib 0) 0)))
  (testing "fib 1" (is (= (fib 1) 1)))
  (testing "fib 2" (is (= (fib 2) 1.0)))
  (testing "fib 3" (is (= (fib 3) 2.0)))
  (testing "fib 4" (is (= (fib 4) 3.0)))
  (testing "fib 5" (is (= (fib 5) 5.0)))
  (testing "fib 6" (is (= (fib 6) 8.0)))
)