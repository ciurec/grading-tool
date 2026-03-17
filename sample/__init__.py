import os
import re
import shutil
import difflib
import glob
import csv
import subprocess
from tabulate import tabulate  # Ensure you import the correct function

# Path to the directory where you want to clone the repositories
STUDENT_REPOS_DIR = 'C:/Users/Catalin Ciurean/Desktop/verificare'
# List of student names and their corresponding GitHub repositories
STUDENT_REPO_MAP = {
    # Prima listă de studenți
    'Anechitei Bianca - Patricia': 'https://github.com/isp-cluj/isp-2026-anepatricia',
    'Ari Andrada Maria': 'https://github.com/isp-cluj/isp-2026-AriAndrada',
    'Bobon Denis - Alexandru': '  ',
    'Bordas Razvan - Vlad': 'https://github.com/isp-cluj/isp-2026-BordasR',
    'Bozomala Stefan - Iulian': 'https://github.com/isp-cluj/isp-2026-BozomalaStefan-30126',
    'Chereches Tudor - Mihai': 'https://github.com/isp-cluj/isp-2026-chereches-tudor-30126',
    'Chichisan Liviu Andrei': 'https://github.com/isp-cluj/isp-2026-chichisan-liviu-30126',
    'Fer Andrei - Ioan': 'https://github.com/isp-cluj/isp-2026-Fer-Andrei-30126',
    'Gata Silviu - Paul': 'https://github.com/isp-cluj/isp-2026-Silviu1407',
    'Gheorghitoaia Elena - Denisa': 'https://github.com/isp-cluj/isp-2026-Denisa010.git',
    'Hapca Ionela': 'https://github.com/isp-cluj/isp-2026-ionela-adc',
    'Holhos Patricia - Maria': 'https://github.com/isp-cluj/isp-2026-holhos-patricia-30126',
    'Marin Miruna - Adriana': 'https://github.com/isp-cluj/isp-2026-mirunamarin1',
    'Minteuan Horea Matei': 'https://github.com/isp-cluj/isp-2026-TheLunar1',
    'Nistor Eduard - George': 'https://github.com/isp-cluj/isp-2026-Nistor-Eduard-30126',
    'Oprinca Alexandru': 'https://github.com/isp-cluj/isp-2026-oprinca-alexandru-6',
    'Pataki Andrei': 'https://github.com/isp-cluj/isp-2026-Andre1i4',
    'Perdei Alexandru': 'https://github.com/isp-cluj/isp-2026-perdei-alexandru-30126',
    'Pereni Sebastian': 'https://github.com/isp-cluj/isp-2026-pereni-sebastian-30126',
    'Pirvu Luca - Andrei': 'https://github.com/isp-cluj/isp-2026-Luca-Pirvu-6',
    'Rus Darius - Silviu': 'https://github.com/isp-cluj/isp-2026-Rus-DariusSilviu-30126',
    'Scripca Andrei - David': 'https://github.com/isp-cluj/isp-2026-scripca-andrei-grupa6',
    'Stejerean Jessica Roxana': 'https://github.com/isp-cluj/isp-2026-stejerean-jessica-30126',
    'Topolniceanu Cezar - Paul': 'https://github.com/isp-cluj/isp-2026-topocezar123',
    'Trif Andrei': '',
    'Velea Petru - Silviu': 'https://github.com/isp-cluj/isp-2026-Petru-prog',
    'Wainberg - Draghiciu Virgil - Mihai': 'https://github.com/isp-cluj/isp-2026-wainberg-mihai-6',
    'Zamfir Maria': 'https://github.com/isp-cluj/isp-2026-Maria5400',

    # A doua listă de studenți
    'Arghir Cristian': 'https://github.com/isp-cluj/isp-2026-arghir-cristian-grupa5',
    'Boariu Denis - Marian': 'https://github.com/isp-cluj/isp-2026-Boariu-Denis-Marian-30125',
    'Boila Cristina - Selena': 'https://github.com/isp-cluj/isp-2026-boila-cristina-30125',
    'Bota Georgiana - Cornelia': 'https://github.com/isp-cluj/isp-2026-Bota-Georgiana-30125.git',
    'Caluser Matei - Ciprian': 'https://github.com/isp-cluj/isp-2026-Caluser-Ciprian-30125',
    'Cristea Raoul - Mario': 'https://github.com/isp-cluj/isp-2026-cristea-raoul-mario-30125',
    'Curtean Serbanut - Rares - Stefan': 'https://github.com/isp-cluj/isp-2026-CurteanRares',
    'Dobocan Nicolae - Tiberiu': 'https://github.com/isp-cluj/isp-2026-Dobocan-Nicolae-30125',
    'Faur Stefan': 'https://github.com/isp-cluj/isp-2026-FaurStefan',
    'Hudrea Briana - Antonia': 'https://github.com/isp-cluj/isp-2026-hudrea-briana-antonia-30125',
    'Marian Paul - David': 'https://github.com/isp-cluj/isp-2026-marian-paul-david-30125',
    'Marin George - Teodor': 'https://github.com/isp-cluj/isp-2026-GeorgeMarin13',
    'Matea Adina - Estera': 'https://github.com/isp-cluj/isp-2026-matea-estera-30125',
    'Moldovan Andrei - Gheorghe': '',
    'Nemeth Ilona - Reka': 'https://github.com/isp-cluj/isp-2026-nemeth-ilona-30125',
    'Pop Paul - Darius': '',
    'Prichici Samuel - Vasile': '',
    'Rad Florentina - Norica': 'https://github.com/isp-cluj/isp-2026-FlorentinaRad',
    'Rusu Miruna - Dumitrina': 'https://github.com/isp-cluj/isp-2026-Rusu-Miruna-30125',
    'Sigheartau Raul - Emanuel': 'https://github.com/isp-cluj/isp-2026-Sugheartau-Raul-30125',
    'Silaghi Denis - Calin': 'https://github.com/isp-cluj/isp-2026-Silaghi-Denis-30125',
    'Stelea Dragos - Lucian': 'https://github.com/isp-cluj/isp-2026-Vlasin-Mariana-Ionela-30125',
    'Svintiu Elena': 'https://github.com/isp-cluj/isp-2026-svintiu-elena-30125.git',
    'Szegedi - Hozai Andreea - Octavia - Patricia': 'https://github.com/isp-cluj/isp-2026-szegedi-hozai-patricia-30125.git',
    'Tamiian Traian - Zoran': 'https://github.com/isp-cluj/isp-2026-Tamiian-Zoran-30125',
    'Varvarescu Georgiana - Mihaela': 'https://github.com/isp-cluj/isp-2026-varvarescu-georgiana-30125.git',
    'Vlasin Mariana - Ionela': 'https://github.com/isp-cluj/isp-2026-Vlasin-Mariana-Ionela-30125',
}
EXCLUDED_PACKAGES = ['example', 'test']

# Directory where repositories will be cloned
TEMP_SUBMISSIONS_DIR = 'temp_submissions'

SKIP_PULL = True  # <<-- dacă True, nu mai face 'git pull' pe repo-urile deja clonate

REMOVE_BLANK_LINES = True
STRIP_COMMENTS = True
STRIP_PACKAGE_IMPORTS = True
NORMALIZE_HTML_ENTITIES = True
NORMALIZE_BRACES = True
NORMALIZE_SPACES = True


def find_package_path_simple(repo_path: str) -> str | None:
    candidates = [
        os.path.join(repo_path, 'isp-lab-1-2026-master', 'src'),
        os.path.join(repo_path, 'isp-lab-1-2026', 'src'),
        os.path.join(repo_path, 'src'),
    ]
    for c in candidates:
        if os.path.isdir(c):
            return c
    return None

def check_missing_submissions():
    missing_students = [student for student, repo in STUDENT_REPO_MAP.items() if not repo]
    if missing_students:
        print("⚠️ Studenți fără submit:")
        for student in missing_students:
            print(f" - {student}")
    else:
        print("✅ Toți studenții au făcut submit.")


def prepare_submissions():
    if os.path.exists(TEMP_SUBMISSIONS_DIR):
        shutil.rmtree(TEMP_SUBMISSIONS_DIR)
    os.makedirs(TEMP_SUBMISSIONS_DIR)

    for student_name, github_url in STUDENT_REPO_MAP.items():
        # Sar peste repo-uri lipsă sau URL-uri doar cu spații
        if not github_url or not github_url.strip():
            print(f"⚠️ Repo lipsă/invalid pentru {student_name}, skip...")
            continue

        # Numele de repo (fără .git la final, dacă e cazul)
        url_last = github_url.rstrip('/').split('/')[-1]
        repo_name = url_last[:-4] if url_last.endswith('.git') else url_last

        repo_path = os.path.join(STUDENT_REPOS_DIR, repo_name)

        if os.path.exists(repo_path):
            if SKIP_PULL:
                print(f"⏭️ Skip pull pentru {student_name} ({repo_name})")
            else:
                print(f"🔄 Pulling latest changes pentru {student_name} ({repo_name})...")
                try:
                    subprocess.run(["git", "-C", repo_path, "pull"], check=True)
                except subprocess.CalledProcessError:
                    print(f"❌ Failed to pull latest changes pentru {student_name}, skipping...")
                    continue
        else:
            print(f"🆕 Cloning repository pentru {student_name} ({repo_name})...")
            try:
                subprocess.run(["git", "clone", github_url, repo_path], check=True)
            except subprocess.CalledProcessError:
                print(f"❌ Failed to clone {github_url}, skipping...")
                continue

        package_path = find_package_path_simple(repo_path)
        print(f"🔍 Checking path: {package_path or '(not found)'}")

        if not package_path:
            print(f"❌ Nu am găsit un 'src' valid pentru {student_name}, skipping...")
            continue

        java_files = [
            f for f in glob.glob(os.path.join(package_path, '**', '*.java'), recursive=True)
            if not any(excluded in f for excluded in EXCLUDED_PACKAGES)
        ]

        if not java_files:
            print(f"⚠️ No Java files found pentru {student_name} după excluderi, skipping...")
            continue

        student_dir = os.path.join(TEMP_SUBMISSIONS_DIR, repo_name)
        os.makedirs(student_dir, exist_ok=True)

        for file in java_files:
            shutil.copy(file, student_dir)

    submission_files = glob.glob(os.path.join(TEMP_SUBMISSIONS_DIR, '**', '*.java'), recursive=True)
    return submission_files


def preprocess_text(text: str) -> str:
    # Uniformizează CRLF/LF
    text = text.replace('\r\n', '\n').replace('\r', '\n')

    # 0) Normalizează entitățile HTML pentru operatori (<, >, <=, >=)
    if NORMALIZE_HTML_ENTITIES:
        replacements = {
            '&lt;=': '<=',
            '&gt;=': '>=',
            '&lt;': '<',
            '&gt;': '>',
            '&amp;': '&',
        }
        for k, v in replacements.items():
            text = text.replace(k, v)

    # 1) Elimină comentariile (/* ... */, /** ... */, //...)
    if STRIP_COMMENTS:
        text = re.sub(r'/\*.*?\*/', '', text, flags=re.DOTALL)  # bloc
        text = re.sub(r'//.*', '', text)  # pe linie

    # 2) Elimină liniile package/import
    if STRIP_PACKAGE_IMPORTS:
        lines = []
        for ln in text.split('\n'):
            s = ln.strip()
            if s.startswith('package ') or s.startswith('import '):
                continue
            lines.append(ln)
        text = '\n'.join(lines)

    # 3) Normalizează acoladele de deschidere (dacă sunt pe linie separată sau „lipite”)
    if NORMALIZE_BRACES:
        # Dacă apare o linie doar cu '{', lipește-o de linia precedentă
        text = re.sub(r'\n\s*\{\s*\n', ' {\n', text)
        text = re.sub(r'\n\s*\{\s*', ' { ', text)
        # Dacă semnătura + '{' sunt lipite de următoarea linie, normalizează spacing-ul
        text = re.sub(r'\s+\{\s+', ' { ', text)

    # 4) Normalizează spațiile
    if NORMALIZE_SPACES:
        text = '\n'.join(' '.join(ln.strip().split()) for ln in text.split('\n'))

    return text


def preprocess_lines(text: str):
    text = preprocess_text(text)
    lines = text.split('\n')
    if REMOVE_BLANK_LINES:
        lines = [ln for ln in lines if ln.strip() != '']
    return lines


def compare_files(file1, file2):
    with open(file1, 'r', encoding='utf-8', newline='') as f1:
        text1 = f1.read()
    with open(file2, 'r', encoding='utf-8', newline='') as f2:
        text2 = f2.read()

    file1_lines = preprocess_lines(text1)
    file2_lines = preprocess_lines(text2)

    return difflib.SequenceMatcher(None, file1_lines, file2_lines).ratio()


def detect_duplication(submission_files):
    similarities = []
    for i, file1 in enumerate(submission_files):
        for file2 in submission_files[i + 1:]:
            student1 = get_student_name(file1)
            student2 = get_student_name(file2)

            # compare only between different students
            if student1 == student2:
                continue

            similarity = compare_files(file1, file2)

            # threshold > 0.7
            if similarity > 0.5:
                similarities.append((file1, file2, similarity))

    # sort by similarity descending
    return sorted(similarities, key=lambda x: x[2], reverse=True)


# Function to get student name from the file path
def get_student_name(file_path):
    repo_name = file_path.split(os.path.sep)[-2]
    for student_name, github_url in STUDENT_REPO_MAP.items():
        if repo_name in github_url:
            return student_name
    return "Unknown"


# Print results in a pretty format
def print_results_pretty(similarities):
    headers = ["Student 1", "Student 2", "File 1", "File 2", "Similarity"]
    table = []

    for similarity in similarities:
        file1, file2, ratio = similarity
        student1 = get_student_name(file1)
        student2 = get_student_name(file2)

        # Extract only the file name
        file1_name = os.path.basename(file1)
        file2_name = os.path.basename(file2)

        table.append([student1, student2, file1_name, file2_name, f"{ratio * 100:.2f}%"])

    print(tabulate(table, headers, tablefmt="pretty"))


def save_results(similarities):
    with open('code_duplication_results.csv', mode='w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(['Student 1', 'Student 2', 'File 1', 'File 2', 'Similarity'])

        for similarity in similarities:
            file1, file2, ratio = similarity
            student1 = get_student_name(file1)
            student2 = get_student_name(file2)

            # Extract only the file name
            file1_name = os.path.basename(file1)
            file2_name = os.path.basename(file2)

            writer.writerow([student1, student2, file1_name, file2_name, f"{ratio * 100:.2f}%"])


def run_all():
    check_missing_submissions()
    submission_files = prepare_submissions()
    print(f"Total submission files prepared: {len(submission_files)}")

    similarities = detect_duplication(submission_files)
    print_results_pretty(similarities)
    save_results(similarities)


if __name__ == '__main__':
    run_all()
