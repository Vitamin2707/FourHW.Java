package tree;
import java.util.ArrayList;
import java.util.List;

public class tree<T extends Comparable<T>> {
    private T val;
    private tree left;
    private tree right;
    private tree parent;
    private List<T> listForPrint = new ArrayList<>();

    public T val() {
        return val;
    }

    public tree left() {
        return left;
    }

    public tree right() {
        return right;
    }

    public tree parent() {
        return parent;
    }

    public tree(T val, tree parent) {
        this.val = val;
        this.parent = parent;
    }

    public void add(T... vals) {
        for (T v : vals) {
            add(v);
        }
    }

    public void add(T val) {
        if (val.compareTo(this.val) < 0) {
            if (this.left == null) {
                this.left = new tree(val, this);
            } else if (this.left != null)
                this.left.add(val);
        } else {
            if (this.right == null) {
                this.right = new tree(val, this);
            } else if (this.right != null)
                this.right.add(val);
        }
    }

    private tree<T> _search(tree<T> tree, T val) {
        if (tree == null)
            return null;
        switch (val.compareTo(tree.val)) {
            case 1:
                return _search(tree.right, val);
            case -1:
                return _search(tree.left, val);
            case 0:
                return tree;
            default:
                return null;
        }
    }

    public tree<T> search(T val) {
        return _search(this, val);
    }

    public boolean remove(T val) {
        // Проверяем, существует ли данный узел
        tree<T> tree = search(val);
        if (tree == null) {
            // Если узла не существует, вернем false
            return false;
        }
        tree<T> curTree;
        // Если удаляем корень
        if (tree == this) {
            if (tree.right != null) {
                curTree = tree.right;
            } else
                curTree = tree.left;
            while (curTree.left != null) {
                curTree = curTree.left;
            }
            T temp = curTree.val;
            this.remove(temp);
            tree.val = temp;
            return true;
        }
        // Удаление листьев
        if (tree.left == null && tree.right == null && tree.parent != null) {
            if (tree == tree.parent.left)
                tree.parent.left = null;
            else {
                tree.parent.right = null;
            }
            return true;
        }
        // Удаление узла, имеющего левое поддерево, но не имеющее правого поддерева
        if (tree.left != null && tree.right == null) {
            // Меняем родителя
            tree.left.parent = tree.parent;
            if (tree == tree.parent.left) {
                tree.parent.left = tree.left;
            } else if (tree == tree.parent.right) {
                tree.parent.right = tree.left;
            }
            return true;
        }
        // Удаление узла, имеющего правое поддерево, но не имеющее левого поддерева
        if (tree.left == null && tree.right != null) {
            // Меняем родителя
            tree.right.parent = tree.parent;
            if (tree == tree.parent.left) {
                tree.parent.left = tree.right;
            } else if (tree == tree.parent.right) {
                tree.parent.right = tree.right;
            }
            return true;
        }
        // Удаляем узел, имеющий поддеревья с обеих сторон
        if (tree.right != null && tree.left != null) {
            curTree = tree.right;
            while (curTree.left != null) {
                curTree = curTree.left;
            }
            // Если самый левый элемент является первым потомком
            if (curTree.parent == tree) {
                curTree.left = tree.left;
                tree.left.parent = curTree;
                curTree.parent = tree.parent;
                if (tree == tree.parent.left) {
                    tree.parent.left = curTree;
                } else if (tree == tree.parent.right) {
                    tree.parent.right = curTree;
                }
                return true;
            }
            // Если самый левый элемент НЕ является первым потомком
            else {
                if (curTree.right != null) {
                    curTree.right.parent = curTree.parent;
                }
                curTree.parent.left = curTree.right;
                curTree.right = tree.right;
                curTree.left = tree.left;
                tree.left.parent = curTree;
                tree.right.parent = curTree;
                curTree.parent = tree.parent;
                if (tree == tree.parent.left) {
                    tree.parent.left = curTree;
                } else if (tree == tree.parent.right) {
                    tree.parent.right = curTree;
                }
                return true;
            }
        }
        return false;
    }

    private void _print(tree<T> node) {
        if (node == null)
            return;
        _print(node.left);
        listForPrint.add(node.val);
        System.out.print(node + " ");
        if (node.right != null)
            _print(node.right);
    }

    public void print() {
        listForPrint.clear();
        _print(this);
        System.out.println();
    }

    @Override
    public String toString() {
        return val.toString();
    }
    
    static void preOrder(Node tree, String space) {
        /**
         * Tree
         */
        if (tree != null)
            System.out.println(space + tree.value);
        else {
            System.out.println(space + "nil");
            return;
        }
        if (tree.left != null || tree.right != null) {
            preOrder(tree.left, space + "  ");
            preOrder(tree.right, space + "  ");
        }
    }


public static void main(String[] args) {
  //Создадим дерево с корневым элементом 33
  tree<Integer> tree = new tree<>(33, null);
  tree.add(5, 35, 1, 20, 4, 17, 31, 99, 18, 19, 55, 75);
  //Распечатаем элементы дерева
  tree.print();
  //Удалим корень
  tree.remove(33);
  tree.remove(99);
  tree.remove(17);
  tree.add(18);
  tree.add(34);
  tree.print();
  //Проверяем элементы дерева
  System.out.println(tree);
  System.out.println(tree.left());
  System.out.println(tree.left().left());
  System.out.println(tree.right().left());


  // новое дерево
  Node root = new Node(1);

  Node n2 = new Node(2);
  Node n3 = new Node(3);

  Node n4 = new Node(4);
  Node n5 = new Node(5);
  Node n6 = new Node(6);

  Node n7 = new Node(7);
  Node n8 = new Node(8);
  Node n9 = new Node(9);
  Node n11 = new Node(11);
  Node n20 = new Node(20);

  root.left = n2;
  root.right = n3;

  n2.left = n4;
  n3.left = n5;
  n3.right = n6;

  n4.left = n7;
  n4.right = n9;
  n5.left = n8;

  n6.left = n11;
  n6.right = n20;
  // 1 2 4 7 9 3 5 6 11 20
  preOrder(root, "");
}
}