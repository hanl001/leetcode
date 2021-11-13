class Solution {
    func largestNumber(_ nums: [Int]) -> String {
        var numStrings = nums.map(String.init)
        numStrings.sort {
            Int("\($0)\($1)")! > Int("\($1)\($0)")!
        }

        if numStrings.first == "0" {
            return "0"
        }
        return numStrings.joined()
    }
}

