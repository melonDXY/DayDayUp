public class LRUCache {
    public class Node {
        public int key, value;
        public Node pre, next;
        public Node(int key = -1, int value = -1, Node pre = null, Node next = null){
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    private int capacity, cnt;
    Node dummyhead, dummytail;
    Dictionary<int, Node> keyNode;

    public LRUCache(int capacity) {
        keyNode = new Dictionary<int, Node>();
        this.capacity = capacity;
        dummyhead = new Node();
        dummytail = new Node();
        dummyhead.next = dummytail;
        dummytail.next = dummyhead;
        cnt = 0;
    }
    
    public int Get(int key) {
        if(keyNode.ContainsKey(key)){
            DeleteNode(key);// 删除链表中的关系
            MoveToHead(key);// 移动链表首部
            return keyNode[key].value;                
        }
        return -1;
    }
    
    public void Put(int key, int value) {
        if(keyNode.ContainsKey(key)){
            DeleteNode(key);// 删除节点前后关系
            keyNode[key].value = value; // 改变节点的值
            MoveToHead(key);// 将节点移至链表首部
        }
        else
        {
            if(cnt == capacity)
            {
                int deleteKey = DeleteTailNode();
                keyNode.Remove(deleteKey);
                AddNewNode(key, value);

            }
            else
            {
                ++ cnt;
                AddNewNode(key, value);
            }
        }
    }

    // 删除尾部节点前后关系
    public int DeleteTailNode(){
        Node temp = dummytail.pre;
        dummytail.pre = temp.pre;
        dummytail.pre.next = dummytail;
        return temp.key;
    }

    // 添加新节点
    public void AddNewNode(int key, int value){
        Node cur = new Node(key, value, dummyhead, dummyhead.next);
        keyNode.Add(key, cur);
        MoveToHead(key);// 将节点放置链表首部
    }


    // 将节点移至链表首，更新节点位置
    public void MoveToHead(int key){
        Node cur = keyNode[key];
        Node tempNext = dummyhead.next;
        cur.next = tempNext;
        tempNext.pre = cur;
        dummyhead.next = cur;
        cur.pre = dummyhead;
    }

    // 删除节点的前后关系
    public void DeleteNode(int key){
        Node temp = keyNode[key];
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */