package top.lytree.leetcode.base;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import top.lytree.json.JSONArray;

import java.util.Arrays;

public class Utils {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(node.val).append(", ");
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static int[][] stringToInt2dArray(String input) {
        ArrayNode nodes = JSONArray.parseJSONArray(input);
        if (nodes.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[nodes.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonNode node = nodes.get(i);
            arr[i] = stringToIntegerArray(node.toString());
        }
        return arr;
    }

    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            sb.append(Arrays.toString(item));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }


}
