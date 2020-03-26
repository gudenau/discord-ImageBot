TARGET		:=	../resources/res/natives/amd64/libmagick.so

DIR_SRC		:=	source
DIR_INC		:=	include
DIR_BLD		:=	build
DIR_JDK		:=	/usr/lib/jvm/jdk-14

FILES_C		:=	$(wildcard $(DIR_SRC)/*.c)
FILES_CXX	:=	$(wildcard $(DIR_SRC)/*.cpp)
FILES_O		:=	$(patsubst $(DIR_SRC)/%.c,$(DIR_BLD)/%.c.o,$(FILES_C)) \
				$(patsubst $(DIR_SRC)/%.cpp,$(DIR_BLD)/%.cpp.o,$(FILES_CXX))
FILES_J		:=	$(shell find ../java/net/gudenau/discord/images/magick | grep \\.java)

LIBS		:=	GraphicsMagick # lcms2 freetype Xext SM ICE X11 lzma bz2 z ltdl m pthread gomp
FILES_INC	:=	include \
				$(DIR_JDK)/include $(DIR_JDK)/include/linux \
				$(DIR_BLD)/java/header \
				/usr/include/GraphicsMagick

FLAGS_CC	:=	-Wall -Wextra -Werror -O2 -c \
				-std=c17 -fPIC \
				$(addprefix -I,$(FILES_INC))
FLAGS_CXX	:=	-Wall -Wextra -Werror -O2 -c \
				-std=c++17 -fPIC -fno-exceptions \
				$(addprefix -I,$(FILES_INC))
FLAGS_LD	:=	-Wall -Wextra -Werror -O2 \
				-shared -fPIC \
				$(addprefix -l,$(LIBS)) #\
				#-L lib/install/usr/local/lib

CC			:=	clang
CXX			:=	clang++
LD			:=	clang
JAVAC		:=	$(DIR_JDK)/bin/javac

all: buildDirs headers $(TARGET)

clean:
	rm -vf $(TARGET) $(FILES_O)

buildDirs:
	mkdir -p $(DIR_BLD) $(DIR_BLD)/java/header $(DIR_BLD)/java/class

headers: $(FILES_J)
	$(JAVAC) -cp ../java:lib/jsr305-3.0.2.jar -h $(DIR_BLD)/java/header -d $(DIR_BLD)/java/class $(FILES_J)

$(TARGET): $(FILES_O)
	$(LD) -o $@ $^ $(FLAGS_LD)

$(DIR_BLD)/%.c.o: $(DIR_SRC)/%.c
	$(CC) $(FLAGS_CC) -o $@ $^

$(DIR_BLD)/%.cpp.o: $(DIR_SRC)/%.cpp
	$(CXX) $(FLAGS_CXX) -o $@ $^
