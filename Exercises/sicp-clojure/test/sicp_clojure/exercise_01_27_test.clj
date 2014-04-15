(ns sicp-clojure.exercise_01_27-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_27 :refer :all]))

(deftest c-test
  (testing "Carmichael 560" (is (not (congruent-test 560))))
  (testing "Carmichael 561" (is (= (congruent-test 561) true)))
  (testing "Carmichael 562" (is (not (congruent-test 562))))

  (testing "Carmichael 1104" (is (not (congruent-test 1104))))
  (testing "Carmichael 1105" (is (congruent-test 1105)))
  (testing "Carmichael 1106" (is (not (congruent-test 1106))))

  (testing "Carmichael 1728" (is (not (congruent-test 1728))))
  (testing "Carmichael 1729" (is (congruent-test 1729)))
  (testing "Carmichael 1730" (is (not (congruent-test 1730))))

  (testing "Carmichael 2464" (is (not (congruent-test 2464))))
  (testing "Carmichael 2465" (is (congruent-test 2465)))
  (testing "Carmichael 2466" (is (not (congruent-test 2466))))

  (testing "Carmichael 2820" (is (not (congruent-test 2820))))
  (testing "Carmichael 2821" (is (congruent-test 2821)))
  (testing "Carmichael 2822" (is (not (congruent-test 2822))))

  (testing "Carmichael 6600" (is (not (congruent-test 6600))))
  (testing "Carmichael 6601" (is (congruent-test 6601)))
  (testing "Carmichael 6602" (is (not (congruent-test 6602))))
)
