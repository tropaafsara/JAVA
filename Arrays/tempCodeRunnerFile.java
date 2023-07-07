Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int i = 0;
        int j = i + (m-1);
        while (j < arr.length) {
            int min = arr[i];
            int max = arr[j];
            int minDiff2 = max - min;
            i++;
            j++;
            minDiff = Math.min( minDiff2, minDiff);
        }
        return (long)minDiff;