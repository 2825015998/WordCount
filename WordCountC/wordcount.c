#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main (int argc, char *argv[]) {

	char ch;
	char fh=' ';
	int count = 0;

	FILE *pt;

	if ((pt = fopen(argv[2], "r")) == NULL) {

		printf("打开文件 %s 失败！", argv[2]);

		exit(1);
	}

	if (strcmp(argv[1], "-c") == 0) {
		while ((ch = getc(pt)) != EOF) {
			count++;//统计字符数
		}
		printf("字符数%d个\n", count);
	} 
	else {
		while ((ch = getc(pt)) != EOF) {
			if((ch>=33&&ch<=43)||(ch>=45&&ch<=126)&&((fh==' ')||(fh==',')))
                {
                    count++;//统计单词数
                }
                fh=ch;
		}
		printf("单词数%d个\n", count);
	}

	fclose(pt);
	return 0;
}




