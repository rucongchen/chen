package Student;
	public class Student{ //学生类
    String name;
    String sex;
    Subject[] subjects;
    Student(){
    	
    }
    Student(String name,String sex,Subject[] subjects){
        this.name=name;
        this.sex=sex;
        this.subjects=subjects;
    }

    //成员内部类：课程类
    class Subject{
        String subjectName;
        SubjectType st;
        int atten;
        int assign;
        int lab;
        int finalExam;
        Subject(){
        	
        }
        Subject(String subjectName ,String st,int atten,int assign,int lab,int finalExam){
            this.subjectName=subjectName;
            this.st=new SubjectType(st);
            this.atten=atten;
            this.assign=assign;
            this.lab=lab;
            this.finalExam=finalExam;
        }
    }
  //静态内部类
    static class SubjectType{
        String type;
        double attenRatio;
        static final double assignRatio=0.1;
        static final double labRatio=0.1;
        double finalRatio;
        SubjectType(String type){
            this.type=type;
            setRatio();
        }
        void setRatio( ){
            if(type=="考试"){
                attenRatio=0.1;
                finalRatio=0.7;
                }
            if(type=="考查"){
                attenRatio=0.2;
                finalRatio=0.6;
                }
        }
    }
    //打印方法
   void printInfo(){
        class calcScore{ //局部内部类
            //用于计算总分
            int calcTotal(Subject sb){ 
               return (int) (sb.st.attenRatio*sb.atten+sb.st.assignRatio*sb.assign+sb.st.labRatio*sb.lab+sb.st.finalRatio*sb.finalExam);
               
            }
        }
        calcScore m=new calcScore();
        System.out.println("姓名："+this.name+"  性别："+this.sex);
        System.out.println("课程"+"\t"+"性质"+"\t"+"出勤"+"\t"+"作业"+"\t"+"实验"+"\t"+"期末"+"\t"+"总分");
        System.out.println("==========================================");
        for(int i=0;i<subjects.length;i++) {
        System.out.println(subjects[i].subjectName+"\t"+subjects[i].st.type+"\t"+subjects[i].atten+"\t"+subjects[i].assign+"\t"+subjects[i].lab+"\t"+subjects[i].finalExam+"\t"+m.calcTotal(subjects[i]));
        }
        System.out.println("******************************************");
   }
	
    public static void main(String[] args) {
        Subject[] n1=new Subject[] {
        		new Student().new Subject("Java","考查",90,85,75,80),
        		new Student().new Subject("SQL","考试",80,90,82,75),
        		new Student().new Subject("J2EE","考查",78,70,65,70)
        };
        Student a1=new Student("李红","女",n1);
        a1.printInfo();
        Subject[] n2=new Subject[] {
        		new Student().new Subject("Java","考查",86,67,71,70),
        		new Student().new Subject("SQL","考试",77,70,85,66),
        		new Student().new Subject("J2EE","考查",88,74,68,80)
        };
        Student a2=new Student("王晓明","男",n2);
        a2.printInfo();
    }
    }
	