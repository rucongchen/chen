package Student;
	public class Student{ //ѧ����
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

    //��Ա�ڲ��ࣺ�γ���
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
  //��̬�ڲ���
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
            if(type=="����"){
                attenRatio=0.1;
                finalRatio=0.7;
                }
            if(type=="����"){
                attenRatio=0.2;
                finalRatio=0.6;
                }
        }
    }
    //��ӡ����
   void printInfo(){
        class calcScore{ //�ֲ��ڲ���
            //���ڼ����ܷ�
            int calcTotal(Subject sb){ 
               return (int) (sb.st.attenRatio*sb.atten+sb.st.assignRatio*sb.assign+sb.st.labRatio*sb.lab+sb.st.finalRatio*sb.finalExam);
               
            }
        }
        calcScore m=new calcScore();
        System.out.println("������"+this.name+"  �Ա�"+this.sex);
        System.out.println("�γ�"+"\t"+"����"+"\t"+"����"+"\t"+"��ҵ"+"\t"+"ʵ��"+"\t"+"��ĩ"+"\t"+"�ܷ�");
        System.out.println("==========================================");
        for(int i=0;i<subjects.length;i++) {
        System.out.println(subjects[i].subjectName+"\t"+subjects[i].st.type+"\t"+subjects[i].atten+"\t"+subjects[i].assign+"\t"+subjects[i].lab+"\t"+subjects[i].finalExam+"\t"+m.calcTotal(subjects[i]));
        }
        System.out.println("******************************************");
   }
	
    public static void main(String[] args) {
        Subject[] n1=new Subject[] {
        		new Student().new Subject("Java","����",90,85,75,80),
        		new Student().new Subject("SQL","����",80,90,82,75),
        		new Student().new Subject("J2EE","����",78,70,65,70)
        };
        Student a1=new Student("���","Ů",n1);
        a1.printInfo();
        Subject[] n2=new Subject[] {
        		new Student().new Subject("Java","����",86,67,71,70),
        		new Student().new Subject("SQL","����",77,70,85,66),
        		new Student().new Subject("J2EE","����",88,74,68,80)
        };
        Student a2=new Student("������","��",n2);
        a2.printInfo();
    }
    }
	