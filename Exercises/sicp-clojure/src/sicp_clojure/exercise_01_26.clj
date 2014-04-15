; By replacing the square function with explicit multiplication, Louis' solution
; needs to evaluate each expmod twice, and it builds a recursive evaluation tree,
; instead of taking advantage of tail recursion.