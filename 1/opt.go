func twoSum(nums []int, target int) []int {
    m := make(map[int]int)
    for index, value:= range nums {
        result, ok := m[target-value]
        if ok!=false {
            return []int{result,index}
        }
        m[value]=index

    }
    return []int{0,0}
}