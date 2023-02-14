#include <iostream>
#include <fstream>
using namespace std;

class cppIOclass {
    public:
    string data;
    int total = 0; 
    int count = 0;

    void processString(string inFile2, string outFile2){

        ifstream inFile (inFile2);
        ofstream outFile (outFile2);

        outFile << "in processString" << endl;
        total = 0;
        count = 0;

        while(inFile >> data){
            outFile << data << " ";
            total++;
            count++;
            if(count >= 5){
                outFile << "\nend of text line" << endl;
                count = 0;
            }
        }

        outFile << "\nThe total string count is " << total << ".";
        outFile.close();
        inFile.close();
    }

};


int main(int argc, char** argv) {
    cppIOclass editor;
    editor.processString(argv[1],argv[2]);
    return 0;
}