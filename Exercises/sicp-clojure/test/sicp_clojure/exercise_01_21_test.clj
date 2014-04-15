(ns sicp-clojure.exercise_01_21-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_21 :refer :all]))

(deftest p-test
  (testing "Prime 2" (is (prime? 2)))
  (testing "Prime 3" (is (prime? 3)))
  (testing "Prime 4" (is (not (prime? 4))))
  (testing "Prime 5" (is (prime? 5)))
  (testing "Prime 6" (is (not (prime? 6))))
)

(deftest fp-test
  (testing "FPrime 2" (is (fast-prime? 2 5)))
  (testing "FPrime 3" (is (fast-prime? 3 5)))
  (testing "FPrime 4" (is (not (fast-prime? 4 5))))
  (testing "FPrime 5" (is (fast-prime? 5 5)))
  (testing "FPrime 6" (is (not(fast-prime? 6 5))))
)

(deftest sd-test
  (testing "SD 199"   (is (= (smallest-divisor 199) 199)))
  (testing "SD 1999"  (is (= (smallest-divisor 1999) 1999)))
  (testing "SD 19999" (is (= (smallest-divisor 19999) 7)))
)

(deftest expmod-test
  (testing "expmod 2 5 5" (is (= (expmod 2 5 5) 2)))
)