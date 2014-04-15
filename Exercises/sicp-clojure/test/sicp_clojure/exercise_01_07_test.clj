(ns sicp-clojure.exercise_01_07-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_07 :refer :all]))

(defn near [a b]
  (< (Math/abs (- a b)) 0.001))

(deftest ex_01_07-test
  (testing "Test function truth" (is (near 1.0 1.0001)))
  (testing "Test function false" (is (near 1.0 1.001)))
  (testing "Sqrt" (is (near (sqrt 9) 3)))
  (testing "Complex Sqrt" (is (near (sqrt (+ 100 37)) 11.704)))
  (testing "VComplex Sqrt" (is (near (sqrt (+ (sqrt 2) (sqrt 3))) 1.7739)))
  (testing "Reversibility" (is (near (square (sqrt 1000)) 1000)))
  (testing "Sqrt2" (is (near (sqrt2 9) 3)))
  (testing "Complex Srt2" (is (near (sqrt2 (+ 100 37)) 11.704)))
  (testing "VComplex Sqrt2" (is (near (sqrt2 (+ (sqrt2 2) (sqrt2 3))) 1.7739)))
  (testing "Sqrt2 Reversibility" (is (near (square (sqrt2 1000)) 1000)))
)