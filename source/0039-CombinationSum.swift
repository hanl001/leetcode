class Solution {
    func combinationSum(_ candidates: [Int], _ target: Int) -> [[Int]] {
        var results = [[Int]]()
        var subResults = [Int]()
        dfs(candidates, results, subResults, target, 0)
        return results
    }
    
    private func dfs(_ candidates: [Int], _ results: [[Int]], _ subResults: [Int], _ target: Int, _ index: Int) {
        if (index == candidates.count) {
            return
        }
        if (target == 0) {
            results.add(subResults)
            return
        }
        dfs(candidates, results, subResults, target, index + 1)
        if (target >= candidates[index]) {
            subResults.add(candidates[index])
            dfs(candidates, results, subResults, target - candidates[index], index)
            subResults.removeLast()
        }
    }
}
