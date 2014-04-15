(ns sicp-clojure.exercise_01_13-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_13 :refer :all]))

(deftest fib1-test
  (testing "fib1 0" (is (= (fib1 0) 0)))
  (testing "fib1 1" (is (= (fib1 1) 1)))
  (testing "fib1 2" (is (= (fib1 2) 1)))
  (testing "fib1 3" (is (= (fib1 3) 2)))
  (testing "fib1 4" (is (= (fib1 4) 3)))
  (testing "fib1 5" (is (= (fib1 5) 5)))
  (testing "fib1 6" (is (= (fib1 6) 8)))
)

(deftest fib2-test
  (testing "fib2 0" (is (= (fib2 0) 0)))
  (testing "fib2 1" (is (= (fib2 1) 1)))
  (testing "fib2 2" (is (= (fib2 2) 1)))
  (testing "fib2 3" (is (= (fib2 3) 2)))
  (testing "fib2 4" (is (= (fib2 4) 3)))
  (testing "fib2 5" (is (= (fib2 5) 5)))
  (testing "fib2 6" (is (= (fib2 6) 8)))
)

(def integers (range))
(def values (take 20 (drop 1 integers)))
(def fib1s (map fib1 values))
(def fib2s (map fib2 values))
(defn zip [l1 l2] (map vector l1 l2))
(def fibs (zip fib1s fib2s))
(defn matches [v]
  (= (peek v) (peek (pop v))))

(deftest v-test
  (testing "values" (is (= values '(1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20))))
  (testing "Fib functions give same result for the first 20 integers"
           (is (every? matches fibs)))
)