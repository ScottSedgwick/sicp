;; We are back to lazy evaluation.
;; If new-if was using applicative order evaluation, then it would work.
;; Using normal order, however, requires it to evaluate both clauses
;; despite the value of the predicate, so you cannot use the new-if
;; function to terminate recursion.