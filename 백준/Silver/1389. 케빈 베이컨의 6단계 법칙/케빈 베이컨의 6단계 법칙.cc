#include <iostream>
#include <list>
#include <queue>

using namespace std;

int BFS(list<short>* friends, short N);

class info
{
public:
	short person;
	short count;
};

int main()
{
	short N, M;
	cin >> N >> M;

	list<short>* friends = new list<short>[N + 1];

	for (int i = 0; i < M; i++)
	{
		short person1, person2;
		cin >> person1 >> person2;
		friends[person1].push_back(person2);
		friends[person2].push_back(person1);
	}

	int min = BFS(friends, N);

	cout << min;

	return 0;
}

int BFS(list<short>* friends, short N)
{
	int min = 10000;
	int minPerson = 0;
	for (int i = 1; i <= N; i++)
	{
		int sum = 0;

		bool* visited = new bool[N + 1];
		for (int j = 1; j <= N; j++)
		{
			visited[j] = false;
		}

		visited[i] = true;
		queue<info> queue;
		list<short>::iterator iter;
		for (iter = friends[i].begin(); iter != friends[i].end(); iter++)
		{
			if (!visited[*iter])
			{
				visited[*iter] = true;
				sum += 1;
				queue.push(info{ *iter, 2 });
			}
		}

		while (!queue.empty())
		{
			info information = queue.front();
			queue.pop();

			for (iter = friends[information.person].begin(); iter != friends[information.person].end(); iter++)
			{
				if (!visited[*iter])
				{
					visited[*iter] = true;
					sum += information.count;
					queue.push(info{ *iter, (short)(information.count + 1) });
				}
			}
		}

		if (min > sum)
		{
			min = sum;
			minPerson = i;
		}
	}

	return minPerson;
}