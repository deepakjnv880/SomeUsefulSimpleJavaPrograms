package usefulPrograms;

/**
 Custom hash map using own LinkedList and simple modules to compute hash key.
 One could use hashcode as well before applying modules.
 For other key type like string extra, hashcode can be used.
 */
public class MyHashMap {
    MyLinkedList map[];
    final int noOfBucket;

    public MyHashMap() {
        noOfBucket=100000;
        map=new MyLinkedList[noOfBucket];
    }

    public void put(int key, int value) {
        int bucket=key%noOfBucket;
        MyLinkedList ld=map[bucket];
        if(ld==null){
            map[bucket]=new MyLinkedList(key,value);
        }else{
            while(ld!=null){
                if(ld.key==key){
                    ld.value=value;
                    break;
                }
                else if(ld.next==null){
                    ld.next=new MyLinkedList(key,value);
                    break;
                }
                ld=ld.next;
            }
        }
    }

    public int get(int key) {
        int bucketNo=key%noOfBucket;
        MyLinkedList ld=map[bucketNo];
        while(ld!=null){
            if(ld.key==key){
                return ld.value;
            }
            ld=ld.next;
        }
        return -1;
    }

    public void remove(int key) {
        int bucketNo=key%noOfBucket;
        MyLinkedList ld=map[bucketNo];
        MyLinkedList pre=null;
        while(ld!=null){
            if(ld.key==key){
                if(pre==null){
                    map[bucketNo]=map[bucketNo].next;
                }
                else{
                    pre.next=ld.next;
                }
                break;
            }
            pre=ld;
            ld=ld.next;
        }
        return;
    }

    private class MyLinkedList{
        int key;
        int value;
        MyLinkedList next;

        MyLinkedList(int key,int value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
}
