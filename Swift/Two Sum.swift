class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var numIndexMap = [Int: Int]()
        for (i, num) in nums.enumerated() {
            if let j = numIndexMap[target - num] {
                return [i, j]
            } else {
                numIndexMap[num] = i
            }
        }
        return []
    }
}
