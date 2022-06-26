const questions = [
    ...Array(10).fill(2),
    ...Array(10).fill(4),
    ...Array(5).fill(8),
]

function dfs(idx, score, err, target) {
    if (idx >= questions.length || err >= 3) {
        if (score === target) {
            return 1
        } else {
            return 0
        }
    }

    let count1 = dfs(idx + 1, score + questions[idx], err, target)
    let count2 = dfs(idx + 1, score, err + 1, target)

    return count1 + count2
}

function count(N) {
    return dfs(0, 0, 0, N)
}

console.log(count(100))