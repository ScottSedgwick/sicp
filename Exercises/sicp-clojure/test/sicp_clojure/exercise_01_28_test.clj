(ns sicp-clojure.exercise_01_28-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.exercise_01_28 :refer :all]))

(deftest c-test
	(testing "fp 25" (is (not (fermat-prime? 25))))
	(testing "fp 27" (is (not (fermat-prime? 27))))
	(testing "fp 29" (is (fermat-prime? 29)))
	(testing "fp 31" (is (fermat-prime? 31)))

	(testing "mr 25" (is (not (mr-prime? 25))))
	(testing "mr 27" (is (not (mr-prime? 27))))
	(testing "mr 29" (is (mr-prime? 29)))
	(testing "mr 31" (is (mr-prime? 31)))
)