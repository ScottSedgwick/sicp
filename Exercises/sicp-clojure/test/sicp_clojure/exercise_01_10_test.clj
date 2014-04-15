(ns sicp-clojure.exercise_01_10-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_10 :refer :all]
            [sicp-clojure.exercise_01_08 :refer :all]))

(deftest sqrt-test
  (testing "sqrt" (is (< (Math/abs (- (sqrt 4) 2)) 0.00001))))

(deftest A-test
  (testing "A 1 10" (is (= (A  1 10) 1024)))
  (testing "A 2 4"  (is (= (A  2  4) 65536)))
  (testing "A 3 3"  (is (= (A  3  3) 65536)))
)

(deftest f-test
  (testing "f 0" (is (= (f 0) (f2 0))))
  (testing "f 1" (is (= (f 1) (f2 1))))
  (testing "f 2" (is (= (f 2) (f2 2))))
  (testing "f 3" (is (= (f 3) (f2 3))))
  (testing "f 5" (is (= (f 5) (f2 5))))
)

(deftest g-test
  (testing "g 0" (is (= (g 0) (g2 0))))
  (testing "g 1" (is (= (* (g 1) 1.0) (g2 1))))
  (testing "g 2" (is (= (* (g 2) 1.0) (g2 2))))
  (testing "g 3" (is (= (* (g 3) 1.0) (g2 3))))
  (testing "g 5" (is (= (* (g 5) 1.0) (g2 5))))
)

(deftest h-test
  (testing "h 0" (is (= (h 0) (h2 0))))
  (testing "h 1" (is (= (h 1) (h2 1))))
  (testing "h 2" (is (= (* (h 2) 1.0) (h2 2))))
  (testing "h 3" (is (= (* (h 3) 1.0) (h2 3))))
  (testing "h 4" (is (= (* (h 4) 1.0) (h2 4))))
)

(deftest k-test
  (testing "k 0" (is (= (* (k 0) 1.0) (k2 0))))
  (testing "k 1" (is (= (* (k 1) 1.0) (k2 1))))
  (testing "k 2" (is (= (* (k 2) 1.0) (k2 2))))
  (testing "k 3" (is (= (* (k 3) 1.0) (k2 3))))
  (testing "k 5" (is (= (* (k 5) 1.0) (k2 5))))
)
