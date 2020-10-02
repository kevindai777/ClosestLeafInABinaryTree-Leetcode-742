let map = {}
    let match = dfs(root, map, k)
    let queue = [match]
    
    while (queue.length) {
        let curr = queue.shift()
        if (!curr.left && !curr.right) {
            return curr.val
        }
        
        if (curr.left) {
            queue.push(curr.left)
        }
        
        if (curr.right) {
            queue.push(curr.right)
        }
        
        if (map[curr] != undefined) {
            queue.push(map[curr])
            map[curr] = undefined
        }
    }
    
    return -1
    
    function dfs(node, map, k) {
        if (!node) {
            return null
        }
        
        if (node.val == k) {
            return node
        }
        
        if (node.left) {
            map[node.left] = node
            let left = dfs(node.left, map, k)
            if (left) {
                return left
            }
        }
        
        if (node.right) {
            map[node.right] = node
            let right = dfs(node.right, map, k)
            if (right) {
                return right
            }
        }
        
        return null
    }