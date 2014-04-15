(ns sicp-clojure.exercise_01_16-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_16 :refer :all]))

(deftest ex_01_16-test
  (testing "fe1 2 2" (is (= (fast-expt1 2 2) 4.0)))
  (testing "fe1 2 3" (is (= (fast-expt1 2 3) 8.0)))
  (testing "fe1 2 4" (is (= (fast-expt1 2 4) 16.0)))
  (testing "fe1 2 5" (is (= (fast-expt1 2 5) 32.0)))
  (testing "fe1 2 6" (is (= (fast-expt1 2 6) 64.0)))
  (testing "fe1 2 7" (is (= (fast-expt1 2 7) 128.0)))
  (testing "fe1 2 8" (is (= (fast-expt1 2 8) 256.0)))
  (testing "fe2 2 2" (is (= (fast-expt2 2 2) 4.0)))
  (testing "fe2 2 3" (is (= (fast-expt2 2 3) 8.0)))
  (testing "fe2 2 4" (is (= (fast-expt2 2 4) 16.0)))
  (testing "fe2 2 5" (is (= (fast-expt2 2 5) 32.0)))
  (testing "fe2 2 6" (is (= (fast-expt2 2 6) 64.0)))
  (testing "fe2 2 7" (is (= (fast-expt2 2 7) 128.0)))
  (testing "fe1 2 8" (is (= (fast-expt1 2 8) 256.0)))
)